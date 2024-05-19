class InvalidYearException extends Exception {
        public InvalidYearException(String message){
            super(message);
        }
}
class DuplicateBookException extends Exception {
    public DuplicateBookException(String message){
        super(message);
    }
}
class BookNotFoundException extends Exception {
    public BookNotFoundException(String message){
        super(message);
    }
}