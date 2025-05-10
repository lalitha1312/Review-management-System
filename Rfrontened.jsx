import React, { useState, useEffect } from "react";
import axios from "axios";
import BookCard from "./components/BookCard";
import "./App.css";

const API_URL = "http://localhost:8080/api/books";

const App = () => {
    const [books, setBooks] = useState([]);
    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [genre, setGenre] = useState("");
    const [filter, setFilter] = useState("All");

    useEffect(() => {
        fetchBooks();
    }, []);

    const fetchBooks = async () => {
        try {
            const response = await axios.get(API_URL);
            setBooks(response.data);
        } catch (error) {
            console.error("Error fetching books:", error);
        }
    };

    const addBook = async () => {
        if (!title || !author || !genre) {
            alert("Please fill in all fields!");
            return;
        }

        const newBook = { title, author, genre };

        try {
            const response = await axios.post(API_URL, newBook);
            setBooks([...books, response.data]);
            setTitle("");
            setAuthor("");
            setGenre("");
        } catch (error) {
            console.error("Error adding book:", error);
        }
    };

    const filteredBooks = filter === "All" ? books : books.filter(book => book.genre === filter);

    return (
        <div className="app-container">
            <h1>📚 Book Review App</h1>

            <div className="form">
                <input type="text" placeholder="Title" value={title} onChange={(e) => setTitle(e.target.value)} />
                <input type="text" placeholder="Author" value={author} onChange={(e) => setAuthor(e.target.value)} />
                <input type="text" placeholder="Genre" value={genre} onChange={(e) => setGenre(e.target.value)} />
                <button onClick={addBook}>Add Book</button>
            </div>

            <div className="book-list">
                {filteredBooks.map(book => (
                    <BookCard key={book.id} bookId={book.id} />
                ))}
            </div>
        </div>
    );
};

export default App;
