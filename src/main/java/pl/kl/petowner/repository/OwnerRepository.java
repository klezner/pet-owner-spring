package pl.kl.petowner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kl.petowner.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
