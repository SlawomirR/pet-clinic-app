package io.github.slawomirr.petclinicspring.bootstrap;

import io.github.slawomirr.petclinicspring.model.*;
import io.github.slawomirr.petclinicspring.services.OwnerService;
import io.github.slawomirr.petclinicspring.services.SpecialtyService;
import io.github.slawomirr.petclinicspring.services.VetService;
import io.github.slawomirr.petclinicspring.services.map.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner mikeWeston = new Owner();
        mikeWeston.setFirstName("Michael");
        mikeWeston.setLastName("Weston");
        mikeWeston.setAddress("123 Brickerel");
        mikeWeston.setCity("Miami");
        mikeWeston.setTelephone("1231231234");
        ownerService.save(mikeWeston);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(mikeWeston);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        mikeWeston.getPets().add(mikesPet);

        Owner fionaGlenanne = new Owner();
        fionaGlenanne.setFirstName("Fiona");
        fionaGlenanne.setLastName("Glenanne");
        fionaGlenanne.setAddress("123 Brickerel");
        fionaGlenanne.setCity("Miami");
        fionaGlenanne.setTelephone("1231231234");
        ownerService.save(fionaGlenanne);

        Pet fionasPet = new Pet();
        fionasPet.setName("Just Cat");
        fionasPet.setOwner(fionaGlenanne);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setPetType(savedCatPetType);
        fionaGlenanne.getPets().add(fionasPet);

        System.out.println("Loaded Owners....");

        Vet samAxe = new Vet();
        samAxe.setFirstName("Sam");
        samAxe.setLastName("Axe");
        samAxe.getSpecialities().add(savedRadiology);
        vetService.save(samAxe);

        Vet jessiePorter = new Vet();
        jessiePorter.setFirstName("Jessie");
        jessiePorter.setLastName("Porter");
        jessiePorter.getSpecialities().add(savedSurgery);
        vetService.save(jessiePorter);

        System.out.println("Loaded Vets....");
    }
}
