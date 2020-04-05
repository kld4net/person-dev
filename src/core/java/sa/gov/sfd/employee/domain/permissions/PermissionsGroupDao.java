package sa.gov.sfd.employee.domain.permissions;



import sa.gov.sfd.employee.model.PermissionsGroup;

import java.util.List;
import java.util.Optional;

public interface PermissionsGroupDao  {

  List<PermissionsGroup> findAll();

 Optional<PermissionsGroup> findById(Long permissionsGroup);

 List<PermissionsGroup> findByUserNid(Integer userNid);
}
