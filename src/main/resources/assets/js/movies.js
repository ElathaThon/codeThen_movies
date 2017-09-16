


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

        console.log(document.getElementById("title"));


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

/** setup the form to edit a movie */
function setupMoviesFormEdit(movie){

    $('#title').val(movie.title);
    $('#author').val(movie.author);
    $('#year').val(movie.productionYear);
    $('#price').val(movie.price);

    /*
     TODO: Editar les movies
     $('form').submit(event => {

     console.log("Form submitted");
     event.preventDefault(); // prevents default form behaviour (reloads the page)

     const newMovie = {
     title: $('#title').val(),
     author: $('#author').val(),
     productionYear: parseInt($('#year').val()),
     price: parseFloat($('#price').val())
     };

     axios
     .put(apiMoviesUrl + "/" + movie.id, newMovie)
     .then(response => response.data) // turns to a promise of book
     .then(addedMovie => {
     console.log("Added movie", addedMovie);
     loadAndDisplayMovies(); // to refresh list
     })
     .catch(error => console.error("Error adding movie!", error));
     });
     */
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

    let html = "<ul class='list-unstyled'>";

    for (const movie of movies) {

        const id = movie.id;
        const title = movie.title;

        html += "<div>" +
            editMovieButton(movie)

            +"<li onclick='displayDetailMovie("+ id +")'>"
            + title + // Central part with text
            "</li>" +

            deleteMovieButton(id)

            +"</div>";
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

function editMovie() {
    //TODO...
    setupMoviesFormAdd();

}

/* little util functions for this JavaScript file */

/** return the HTML string for the edit button in the list */
function editMovieButton(movie) {
    return "<button class='pull-left' onclick='editMovie(" + movie + ")'><i class='fa fa-pencil-square-o' aria-hidden='true'></i></button>";
}


function deleteMovieButton(id) {
    return "<button class='pull-right' onclick='deleteMovie(" + id + ")'><i class='fa fa-trash' aria-hidden='true'></i></button>";

}

