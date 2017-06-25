function clickShow(self) {
    post('/selectSeat', {
        theater_name:self.name,
        show:$(self).text()
    })
}