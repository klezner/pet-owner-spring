package pl.kl.petowner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
