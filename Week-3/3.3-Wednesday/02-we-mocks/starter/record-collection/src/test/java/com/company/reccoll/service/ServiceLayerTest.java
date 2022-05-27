package com.company.reccoll.service;

import com.company.reccoll.repository.*;
import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    LabelRepository labelRepository;
    TrackRepository trackRepository;

    @Before
    public void setUp() throws Exception {
        setUpAlbumRepositoryMock();
        setUpArtistRepositoryMock();
        setUpLabelRepositoryMock();
        setUpTrackRepositoryMock();

        service = new ServiceLayer(albumRepository, artistRepository, labelRepository, trackRepository);

    }

    @Test
    public void shouldReturnAListOfAlbumViewModelsWhenFindingAllAlbums(){
        List<AlbumViewModel> actualResult = service.findAllAlbums();

        assertEquals(1,actualResult.size());
    }

    @Test//Good inputs
    public void shouldFindArtistById(){
        //ARRANGE - set up expected result (mock is already set up)
        Artist expectedArtist = new Artist();
        expectedArtist.setId(45);//match artist id
        expectedArtist.setInstagram("Biilie@insta");
        expectedArtist.setName("Billie ");
        expectedArtist.setTwitter("Billie@twitter");

        //ACT - call serviceLayer findArtist
        Artist actualResult = service.findArtist(45);

        //ASSERT - compare expected to actual
        assertEquals(expectedArtist,actualResult);
    }

    @Test//Bad inputs
    public void shouldReturnNullWhenFindArtistWithIdThatDoesNotExist(){
        //ARRANGE
        Artist expectedArtist = null;

        //ACT
        Artist actualResult = service.findArtist(10000);

        //Assert
        assertEquals(expectedArtist,actualResult);

    }

    // Helper methods
    private void setUpAlbumRepositoryMock() {
        albumRepository = mock(AlbumRepository.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumRepository).save(album2);
        doReturn(Optional.of(album)).when(albumRepository).findById(1);
        doReturn(aList).when(albumRepository).findAll();
    }

    private void setUpArtistRepositoryMock() {
        artistRepository = mock(ArtistRepository.class);
        Artist artist = new Artist();
        artist.setId(45);//match artist id
        artist.setInstagram("Biilie@insta");
        artist.setName("Billie ");
        artist.setTwitter("Billie@twitter");

        Artist artist2 = new Artist();

        artist.setInstagram("Biilie@insta");
        artist.setName("Billie ");
        artist.setTwitter("Billie@twitter");

        List<Artist> aArtistList = new ArrayList<>();
        aArtistList.add(artist);

        doReturn(artist).when(artistRepository).save(artist2);
        doReturn(Optional.of(artist)).when(artistRepository).findById(45);
        doReturn(aArtistList).when(artistRepository).findAll();

    }

    private void setUpLabelRepositoryMock() {
        labelRepository = mock(LabelRepository.class);
        Label label = new Label();
        label.setId(10);//match label id
        label.setName("Johnny's label");
        label.setWebsite("www.Billie.com ");

        Label label2 = new Label();
        label2.setName("Johnny's label");
        label2.setWebsite("www.Billie.com ");


        List<Label> aLabelList = new ArrayList<>();
        aLabelList.add(label);

        doReturn(label).when(labelRepository).save(label2);
        doReturn(Optional.of(label)).when(labelRepository).findById(10);
        doReturn(aLabelList).when(labelRepository).findAll();
    }

    private void setUpTrackRepositoryMock() {
        trackRepository = mock(TrackRepository.class);
        Track track = new Track();
        track.setId(999);
        track.setAlbumId(1);//match id
        track.setRunTime(240);
        track.setTitle("Never Gonna");

        Track track2 = new Track();
        track2.setAlbumId(1);//match id
        track2.setRunTime(240);
        track2.setTitle("Never Gonna");

        List<Track> aTrackList = new ArrayList<>();// List<Track> aTacklist = Arrays.asList(track);
        aTrackList.add(track);

        doReturn(track).when(trackRepository).save(track2);
        doReturn(Optional.of(track)).when(trackRepository).findById(99);
        doReturn(aTrackList).when(trackRepository).findAll();
        doReturn(aTrackList).when(trackRepository).findAllTracksByAlbumId(1);
    }
}
