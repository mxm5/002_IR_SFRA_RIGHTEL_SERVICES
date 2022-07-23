package com.example.sayehwebservices.controller.rightels;

import com.example.sayehwebservices.Config.exception.DecileInfoCodedException;
import com.example.sayehwebservices.domain.IvrYaranehStat;
import com.example.sayehwebservices.services.IvrServices;
import com.example.sayehwebservices.services.LogsServiece;
import com.example.sayehwebservices.services.dto.DecileInfoResponseDto;
import com.example.sayehwebservices.services.dto.NationalCodeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/convention-status")
@AllArgsConstructor
@Slf4j
public class IVRConventionStatController {

    @Autowired
    LogsServiece logsServiece;

    @Autowired
    IvrServices ivrServices;

    @PostMapping("/by-national-code")
    IvrYaranehStat getRemainingCredit(@RequestBody NationalCodeRequest request) throws DecileInfoCodedException {
        try {
            IvrYaranehStat byResSSN = ivrServices.getByResSSN(request.getNationalCode());
            if (byResSSN != null) logsServiece.logForNationalCodeWithDescriptionAndSuccess(
                    request.getNationalCode(), "ivr-subvention-inquiry", true
            );
            return byResSSN;
        } catch (Exception exception) {
            exception.printStackTrace();
            logsServiece.logForNationalCodeWithDescriptionAndSuccess(
                    request.getNationalCode(),
                    "ivr-subvention-inquiry err:[[" + exception.getMessage() +
                            "]] cause:[[" + exception.getCause().toString() + "]]",
                    false);
            throw exception;
        }
    }
}
