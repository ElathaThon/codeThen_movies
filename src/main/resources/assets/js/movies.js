


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
        console.log(movie)
        const id = movie.id;
        const title = movie.title;

        html +=
                editMovieButton(id)

                +"<li onclick='displayDetailMovie("+ id +")'>" +
                    +"<span class='centralText'>" + title + "</span>" +// Central part with text
                "</li>"

                deleteMovieButton(id);
    }

    html += "</ul>";

    const resultDiv = document.getElementById("result");
    resultDiv.innerHTML = html;
}


/** Displays the detail of the movie */
function displayDetailMovie(id) {
    window.open("movieDetail.html?id=" + id, '_blank');
}

/** Delete the movie with the id parameter */
function deleteMovie(idMovie) {
    let promise = axios.delete(apiMoviesUrl + "/" + idMovie)
        .then(response => response.data) //turns to a promise of movies
        .catch(error => {
            console.log("AJAX request finished with and error:");
            console.error(error);
        });

    promise.then(movies => {
        loadAndDisplayMovies();
    })
}


/* little util functions for this JavaScript file */

/** return the HTML string for the edit button in the list */
function editMovieButton(id) {
    return "<button class='left' onclick='editMovie(" + id + ")'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button>";
}


function deleteMovieButton(id) {
    return "<button onclick='deleteMovie(" + id + ")'><i class='fa fa-trash' aria-hidden='true'></i></button>";

}

