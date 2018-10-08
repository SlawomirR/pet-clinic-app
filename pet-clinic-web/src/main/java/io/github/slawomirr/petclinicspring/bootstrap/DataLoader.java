package io.github.slawomirr.petclinicspring.bootstrap;

import io.github.slawomirr.petclinicspring.model.Owner;
import io.github.slawomirr.petclinicspring.model.Pet;
import io.github.slawomirr.petclinicspring.model.PetType;
import io.github.slawomirr.petclinicspring.model.Vet;
import io.github.slawomirr.petclinicspring.services.OwnerService;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner mikeWeston = new Owner();
        mikeWeston.setFirstName("Michael");
        mikeWeston.setLastName("Weston");
        mikeWeston.setAddress("123 Brickerel");
        mikeWeston.setCity("Miami");
        mikeWeston.setTelephone("1231231234");
        ownerService.save(mikeWeston);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
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
        fionasPet.setPetType(saveCatPetType);
        fionaGlenanne.getPets().add(fionasPet);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(4L); // TODO - delete this after some tests.
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
