function clickShow(self) {
    post('/selectSeat', {
        theater_name:self.name,
        show:$(self).text()
    })
    "redirect:/selectSeat/" + theater_id + "?movie_id=" + movie_id + "&show_id=" + show;
}