package com.example.demo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class User {

    var name = ""

    var userName = ""

    var email = ""

    var mobile = ""

    var password = ""

    var nic = ""

    var emNumber = ""


}
