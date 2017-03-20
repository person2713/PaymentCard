package com.team.mvc.controller;

/**
 * Created by vit on 17.03.2017.
 */
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.team.mvc.entity.CitiesEntity;
import com.team.mvc.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    CitiesService service;

    @Autowired
    MessageSource messageSource;


    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listCities(ModelMap model) {

        List<CitiesEntity> citiesEntities = service.findAllCities();
        model.addAttribute("itiesEntities", citiesEntities);
        return "allcities";
    }

    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        CitiesEntity citiesEntity = new CitiesEntity();
        model.addAttribute("citiesEntity", citiesEntity);
        model.addAttribute("edit", false);
        return "registrationCity";
    }


    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid CitiesEntity citiesEntity, BindingResult result,
                               ModelMap model) {

        if (result.hasErrors()) {
            return "registrationCity";
        }

         /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation
         * and applying it on field [ssn] of Model class [Employee].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */
        if (!service.isCityNameUnique(citiesEntity.getCityId(), citiesEntity.getCityName())) {
            FieldError nameError = new FieldError("citiesEntity", "city_name", messageSource.getMessage("non.unique.city_name", new String[]{citiesEntity.getCityName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registrationCity";
        }

        service.saveEmployee(citiesEntity);

        model.addAttribute("success", "City " + citiesEntity.getCityName() + " registered successfully");
        return "success";
    }

    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{city_name}-citiesEntities" }, method = RequestMethod.GET)
    public String editCity(@PathVariable String city_name, ModelMap model) {
        CitiesEntity citiesEntity = service.findCityByName(city_name);
        model.addAttribute("citiesEntity", citiesEntity);
        model.addAttribute("edit", true);
        return "registrationCity";
    }


    /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
    @RequestMapping(value = { "/edit-{city_name}-citiesEntities" }, method = RequestMethod.POST)
    public String updateCity(@Valid CitiesEntity citiesEntity, BindingResult result,
                                 ModelMap model, @PathVariable String city_name) {

        if (result.hasErrors()) {
            return "registrationCity";
        }

        if(!service.isCityNameUnique(citiesEntity.getCityId(),citiesEntity.getCityName())){
            FieldError city_nameError =new FieldError("citiesEntity","city_name",messageSource.getMessage("non.unique.city_name", new String[]{citiesEntity.getCityName()}, Locale.getDefault()));
            result.addError(city_nameError);
            return "registrationCity";
        }

        service.updateCity(citiesEntity);

        model.addAttribute("success", "City " + citiesEntity.getCityName()  + " updated successfully");
        return "success";
    }


    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{city_name}-citiesEntities" }, method = RequestMethod.GET)
    public String deleteCity(@PathVariable String city_name) {
        service.deleteCityByName(city_name);
        return "redirect:/list";
    }
}
