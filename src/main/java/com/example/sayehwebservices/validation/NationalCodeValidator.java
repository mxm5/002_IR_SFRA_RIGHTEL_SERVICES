package com.example.sayehwebservices.validation;

import com.example.sayehwebservices.repository.SSNSStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class NationalCodeValidator implements ConstraintValidator<NationalCodeValid, String> {

    @Autowired
    SSNSStatRepository ssnsStatRepository;

    @Override
    public boolean isValid(String nationalCode, ConstraintValidatorContext constraintValidatorContext) {
        Integer integer = ssnsStatRepository.checkNationalCodeValidity(nationalCode);
        return (integer == 1);
    }
}
