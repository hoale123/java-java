package com.company.reccoll.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service// a component// autowired
public class ServiceLayer {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;
    private TrackRepository trackRepository;

    @Autowired

    public ServiceLayer(AlbumRepository albumRepository, ArtistRepository artistRepository, LabelRepository labelRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.trackRepository = trackRepository;
    }


    //CREATE Album
    @Transactional// save all or not saving anything. and rollback.
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel){
        // Save the album info
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());

        a = albumRepository.save(a); // creating the data.//save to database and give an id
        viewModel.setId(a.getId());

        // Associate each track with the album (albumId foreign key on track)
        // Add each track to the database
        Set<Track> trackSet = viewModel.getTracks();
        //another way to loop
        trackSet.stream()
                .forEach(song -> {
                    song.setAlbumId(viewModel.getId());
                    trackRepository.save(song);
                });
        trackSet =new HashSet<Track>( trackRepository.findAllTracksByAlbumId(viewModel.getId()));
        viewModel.setTracks(trackSet);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id ){
        //why option? if an album is not there,
        //empty box, gift in a box.
        //if we get an empty box we can see if something is present in there.
        Optional<Album> album = albumRepository.findById(id);


//         return album.isPresent()? buildAlbumViewModel(album.get()) : null;
        if(album.isPresent()){
            return buildAlbumViewModel(album.get());
        }else {
            return null;
        }
    }

    public List<AlbumViewModel> findAllAlbum(){
        List<Album> albumList = albumRepository.findAll();

        List<AlbumViewModel> avmList = new ArrayList<>();

        //get the album put it in list
        for (Album album: albumList){
            //set and built
            AlbumViewModel avm = buildAlbumViewModel(album);
            //add the album to list.
            avmList.add(avm);
        }
        return avmList;
    }

//    UPDATE Album
    @Transactional
    public void updateAlbum(AlbumViewModel viewModel){
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());

        //update the album
        albumRepository.save(a);

        //Delete all the old tracks associated with this album because
        //we have a potentially updated/corrected set on the new view model
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(a.getId());

        trackList.stream()
                .forEach(t -> trackRepository.deleteById(t.getId()));
        // then add all the tracks on this view model into the database
        Set<Track> avmTrackSet = viewModel.getTracks();
        avmTrackSet.stream()
                .forEach(t -> {
                    t.setAlbumId(viewModel.getId());
                    trackRepository.save(t);
                });
    }

    //DELETE Album.
    @Transactional// use to not delete all data.
    public void removeAlbum(int id){
        //delete individual tracks // foreign key constraints
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(id);

        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        // remove album
        albumRepository.deleteById(id);

    }

    // only want the AlbumViewModel to have access
    private AlbumViewModel buildAlbumViewModel(Album album){
        // get the artist
        Optional<Artist> artist = artistRepository.findById(album.getArtistId());
        if (artist.isPresent() == false){
            throw new DataIntegrityViolationException("Label contains non-existent aristId foreign key " + album);
        }
        // get the label
        Optional<Label> label = labelRepository.findById(album.getLabelId());
        if (label.isPresent() == false){
            throw new DataIntegrityViolationException("Label contains non-existent labelId foreign key " + album);
        }
        //get the tracks as set
        Set<Track> tracks = new HashSet<>(trackRepository.findAllTracksByAlbumId(album.getId()));
        if (tracks.size() == 0){
            throw new RuntimeException("Album with id " + album.getId() +" contains no tracks." + album);
        }
        //put all object and properties on the view model
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist.get());
        avm.setLabel(label.get());
        avm.setTracks(tracks);

        //return
        return avm;
    }
}
