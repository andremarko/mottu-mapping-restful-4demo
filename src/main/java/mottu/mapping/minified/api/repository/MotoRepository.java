package mottu.mapping.minified.api.repository;

import mottu.mapping.minified.api.dto.CountSectorDTO;
import mottu.mapping.minified.api.model.Moto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    Page<Moto> findBySector_Yard_YardId(Long yardId, Pageable pageable);
    @Query("SELECT new mottu.mapping.minified.api.dto.CountSectorDTO(s.name, COUNT(m)) " +
            "FROM Moto m JOIN m.sector s " +
            "GROUP BY s.name")
    List<CountSectorDTO> countMotosBySector();
}
