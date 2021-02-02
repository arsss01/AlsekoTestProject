package com.project.alseko.servises;

import com.project.alseko.dto.EmployeesDto;
import com.project.alseko.dto.ResponseDto;
import com.project.alseko.entity.EmployeesEntity;
import com.project.alseko.entity.MaterialValuesEntity;
import com.project.alseko.repositories.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final ModelMapper modelMapper;
    private final EmployeesRepository employeesRepository;

    public EmployeesDto addEmployees(EmployeesDto employeesDto) {
        EmployeesEntity employeesEntity = modelMapper.map(employeesDto, EmployeesEntity.class);
        return modelMapper.map(employeesRepository.save(employeesEntity), EmployeesDto.class);
    }

    public Page<ResponseDto> findAll(Pageable pageable) {
        Page<EmployeesEntity> employees = employeesRepository.findAll(pageable);

        return employees.map(item -> {
           ResponseDto response = new ResponseDto();
           response.setEmployeeId(item.getId());
           response.setName(item.getName());
           response.setSurname(item.getSurname());
           response.setPatronymic(item.getPatronymic());
           response.setQuantity(item.getMaterialValues().size());
           List<Long> count = item.getMaterialValues().stream()
                   .map(MaterialValuesEntity::getCost)
                   .collect(Collectors.toList());
           count.forEach(response::setCommonCost);

           return response;
        });
    }

    public EmployeesDto findByIdEmployees(Integer id) {

        Optional<EmployeesEntity> employeesEntity = employeesRepository.findById(id);

        if (employeesEntity.isPresent()) {
            return modelMapper.map(employeesEntity.get(), EmployeesDto.class);
        } else {
            throw new RuntimeException("" + "not found");
        }

    }

    public EmployeesDto updateEmployees(EmployeesDto employeesDto) {
        int id = employeesDto.getId();
        if (employeesRepository.findById(id).isPresent()){
            EmployeesEntity employeesEntity = modelMapper.map(employeesDto, EmployeesEntity.class);
            return modelMapper.map(employeesRepository.save(employeesEntity), EmployeesDto.class);
        }else {
            throw  new RuntimeException("not found");
        }
    }

    @Transactional
    public void deleteEmployees(Integer id) {
        if (employeesRepository.findById(id).isPresent()){
            employeesRepository.deleteJoin(id);
            employeesRepository.deleteById(id);
        } else {
            throw new RuntimeException("not found");
        }
    }

}
