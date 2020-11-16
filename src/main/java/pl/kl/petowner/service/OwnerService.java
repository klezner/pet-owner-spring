package pl.kl.petowner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kl.petowner.model.Owner;
import pl.kl.petowner.repository.OwnerRepository;

import java.util.List;

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
}
