package casestudy;

public interface FilterService {
    Iterable<Filter>findAll();
    Filter findById(Long id);
    void save(Filter filter);
    void remove(Long id);
}
