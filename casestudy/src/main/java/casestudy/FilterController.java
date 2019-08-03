package casestudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilterController {
    @Autowired
    private FilterService filterService;
    @Autowired
    private NoteService noteService;

    @GetMapping("/filters")
    public ModelAndView showFilter() {
        Iterable<Filter> filters = filterService.findAll();
        ModelAndView modelAndView = new ModelAndView("/filter/list");
        modelAndView.addObject("filters", filters);
        return modelAndView;
    }

    @GetMapping("/create-filter")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/filter/create");
        modelAndView.addObject("filter", new Filter());
        return modelAndView;
    }

    @PostMapping("/create-filter")
    public ModelAndView saveFilter(@ModelAttribute("filter") Filter filter) {
        filterService.save(filter);

        ModelAndView modelAndView = new ModelAndView("/filter/create");
        modelAndView.addObject("filter", filter);
        modelAndView.addObject("message", "filter created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-filter/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Filter filter = filterService.findById(id);
        if (filter != null) {
            ModelAndView modelAndView = new ModelAndView("/filter/edit");
            modelAndView.addObject("filter", filter);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-filter")
    public ModelAndView updateFilter(@ModelAttribute("filter") Filter filter) {
        filterService.save(filter);
        ModelAndView modelAndView = new ModelAndView("/filter/edit");
        modelAndView.addObject("filter", filter);
        modelAndView.addObject("message", "filter updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-filter/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Filter filter = filterService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/filter/delete");
        modelAndView.addObject("filter", filter);
        return modelAndView;
    }

    @PostMapping("/delete-filter")
    public String deleteFilter(@ModelAttribute("filter") Filter filter) {
        filterService.remove(filter.getId());
        return "redirect:filters";
    }

    @GetMapping("/view-filter/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id) {
        Filter filter = filterService.findById(id);
        if (filter == null) {
            return new ModelAndView("/error.404");
        }

        Iterable<Note> notes = noteService.findAllByFilter(filter);

        ModelAndView modelAndView = new ModelAndView("/filter/view");
        modelAndView.addObject("filter", filter);
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
}
