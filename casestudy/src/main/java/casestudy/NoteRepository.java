package casestudy;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    Iterable<Note> findAllByFilter(Filter filter);
}
