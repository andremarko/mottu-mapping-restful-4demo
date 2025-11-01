package mottu.mapping.minified.api.repository;

import mottu.mapping.minified.api.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findByYard_YardId(Long yardId);
}
