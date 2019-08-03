package casestudy;

import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(Long id) {
        noteRepository.delete(id);
    }

    @Override
    public Iterable<Note> findAllByFilter(Filter filter){
        return noteRepository.findAllByFilter(filter);
    }
}
