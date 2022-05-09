package com.TelevisionShows.tvshows.controller;

import com.TelevisionShows.tvshows.TvShows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TvShowsController {


        private List<TvShows> tvShows;

        public TvShowsController() {
            this.tvShows = new ArrayList<>();
            tvShows.add(new TvShows("Ozarks", 2015, 5.00, "Netflix"));
            tvShows.add(new TvShows("Moon Knight", 2022, 5.00, "Disney"));
            tvShows.add(new TvShows("Game of Thrones", 2012, 5.00, "HBO"));
        }

        //Get all
        @RequestMapping(value = "/tvshows", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public List<TvShows> getShows() {
            return tvShows;
        }

        //Get single
        @RequestMapping(value = "/tvshows/{id}", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public TvShows getSingleShow(@PathVariable int id) {
            for (int i = 0; i < tvShows.size(); i++) {
                if (tvShows.get(i).getId() == id) {
                    return tvShows.get(i);
                }
            }
            return null;
        }

        //Update show
        @RequestMapping(value="/tvshows/{id}", method= RequestMethod.PUT)
        @ResponseStatus(HttpStatus.OK)
        public TvShows updateItem(@PathVariable int id, @RequestBody TvShows item) {
            for (int i = 0; i < tvShows.size(); i++) {
                if (tvShows.get(i).getId() == id) {
                    item.setId(id);
                    tvShows.set(i, item);
                    return tvShows.get(i);
                }
            }
            return null;
        }
        //Delete show
        @RequestMapping(value="/tvshows/{id}", method= RequestMethod.DELETE)
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteItem(@PathVariable int id) {
            for (int i = 0; i < tvShows.size(); i++) {
                if (tvShows.get(i).getId() == id) {
                    tvShows.remove(i);
                    return;
                }
            }
        }
        //Create show
        @RequestMapping(value="/tvshows", method= RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public TvShows createItem(@RequestBody TvShows tvShow) {
            tvShows.add(tvShow);
            return tvShow;
        }

    }
