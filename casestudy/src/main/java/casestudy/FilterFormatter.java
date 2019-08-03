package casestudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class FilterFormatter implements Formatter<Filter> {

    private FilterService filterService;

    @Autowired
    public FilterFormatter(FilterService filterService){
        this.filterService = filterService;
    }
    @Override
    public Filter parse(String text, Locale locale) throws ParseException {
        return filterService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Filter object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
