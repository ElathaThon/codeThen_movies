

const apiRootUrl = "/api";
const apiMoviesUrl = apiRootUrl + "/movies";

setupMoviesForm();
loadAndDisplayMovies();


/** Setup of form to add a movie */
function setupMoviesForm() {

    $('form').submit(event => {

        console.log("Form submitted");
        event.preventDefault(); // prevents default form behaviour (reloads the page)

        const movie = {
            title: $('#title').val(),
            author: $('#author').val(),
            productionYear: parseInt($('#year').val()),
            price: parseFloat($('#price').val())
        };

        axios
            .post(apiMoviesUrl, movie)
            .then(response => response.data) // turns to a promise of book
            .then(addedMovie => {
                console.log("Added movie", addedMovie);
                loadAndDisplayMovies(); // to refresh list
            })
            .catch(error => console.error("Error adding movie!", error));
    });
}



/** Loads movies from API and display them */
function loadAndDisplayMovies() {
    loadMovies().then(movies => {
        displayMovies(movies);
    });
}

/** Gets movies from API and returns a promise of movies */
function loadMovies() {
    return axios.get(apiMoviesUrl)
        .then(response => response.data) //turns to a promise of movies
        .catch(error => {
            console.log("AJAX request finished with and error:");
            console.error(error);
        });
}

/** Displays the movies on the HTML */
function displayMovies(movies) {

    let html = "<ul>";

    for (const movie of movies) {
        console.log(movie);
        html += "<li onclick='displayDetailMovie("+movie.id+")'>" + movie.title + "</li>";
    }

    html += "</ul>";

    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = html;
}


/** Displays the detail of the movie */
function displayDetailMovie(id) {
    window.open("movieDetail.html?id=" + id, '_blank');
}