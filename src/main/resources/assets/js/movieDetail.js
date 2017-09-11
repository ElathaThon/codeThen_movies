

setupLoadBody();

function loadAndDisplayMovie(idMovie) {

    let moviePromise = loadMovie(idMovie);
    moviePromise.then(movie => {
        displayMovie(movie);
    });

}

/**
 * Setup the onload to the body and load the movie information
 * */
function setupLoadBody() {
    const body = document.querySelector("body");
    body.onload = function() {

        const idParam = new URLSearchParams(window.location.search).get("id");
        console.log(idParam);

        loadAndDisplayMovie(idParam);

    };
}


/**
 *  Gets movie from API and returns a promise of movie
 *  */
function loadMovie(id) {

    let url = apiMoviesUrl + "/" + id;

    // We return the promise that fetch() gives us
    return axios.get(url)
        .then(response => response.data)
        .catch(error => {
            console.log("AJAX request finished with an error :(");
            console.error(error);
        });
}


/**
 * Displays users on the HTML
 * */
function displayMovie(movie) {

    console.log(movie);

    let html = "El movie with title " + movie.title + " is form the author " + movie.author + ". The production year is " +movie.productionYear+". PRICE: " + movie.price+"€";

    const content = document.getElementById("content");
    content.innerHTML = html;
}
