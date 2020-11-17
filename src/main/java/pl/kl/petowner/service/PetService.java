package pl.kl.petowner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.model.Pet;
import pl.kl.petowner.repository.OwnerRepository;
import pl.kl.petowner.repository.PetRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public Optional<Owner> findOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }

    public void save(Pet pet) {
        petRepository.save(pet);
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
