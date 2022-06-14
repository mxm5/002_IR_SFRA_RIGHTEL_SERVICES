package com.example.sayehwebservices.services;

import com.example.sayehwebservices.repository.AccessRepo;
import com.example.sayehwebservices.services.dto.AccessResponse;
import com.example.sayehwebservices.services.dto.AppAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccessService {
    @Autowired
    AccessRepo accessRepo;

    public AccessResponse getAccessInfo(String nationalCode) {

        AppAccess can_submit_objection = new AppAccess("can_submit_objection", true);
        AppAccess can_view_decile = new AppAccess("can_view_decile", true);
        AppAccess can_register_for_subsidy = new AppAccess("can_register_for_subsidy", false);
        AppAccess can_view_family_info = new AppAccess("can_view_family_info", true);
        AppAccess can_view_economic_info = new AppAccess("can_view_economic_info", true);


        List<AppAccess> accessList = new ArrayList<>(List.of(
                can_submit_objection,
                can_view_decile,
                can_register_for_subsidy,
                can_view_family_info,
                can_view_economic_info
        ));
        String message = " شما در دهک فلان هستید و فلان کار را نمیتوانید بکنید برای اینکار اول ثبت نام کنید ";
        Boolean canEnter = true;
        return new AccessResponse(accessList, message, canEnter);
    }
}
//can_submit_objection//توانایی اعتراض
//can_view_decile//توانایی دیدن دهک
//can_register_for_subsidy//توانایی ثبت نام برای یارانه
//can_view_family_info//توانایی دیدن اطلاعات خانوار
//can_view_economic_info//توانایی دیدن اطلاعات اقتصادی خانوار