package casestudy;

public interface NoteService {
    Iterable<Note>findAll();
    Note findById(Long id);
    void save(Note note);
    void remove(Long id);
    Iterable<Note>findAllByFilter(Filter filter);
}
