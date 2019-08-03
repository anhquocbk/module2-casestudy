package casestudy;

import org.springframework.beans.factory.annotation.Autowired;

public class FilterServiceImpl implements FilterService {
    @Autowired
    private FilterRepository filterRepository;

    @Override
    public Iterable<Filter> findAll() {
        return filterRepository.findAll();
    }

    @Override
    public Filter findById(Long id) {
        return filterRepository.findOne(id);
    }

    @Override
    public void save(Filter filter) {
        filterRepository.save(filter);
    }

    @Override
    public void remove(Long id) {
        filterRepository.delete(id);
    }
}
