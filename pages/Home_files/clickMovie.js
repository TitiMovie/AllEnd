function clickMovie(self) {
    post('/selectShow', {movieName:self.name});
}