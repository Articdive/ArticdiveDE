package de.articdive.website.ccc

data class CSPDataInput(
    // CSP Cost data
    val userCount: Int,
    val envCount: Int,
    val adcCount: Int,
    val copl: Double,
    val cocc: Double,

    // Operational Overhead
    val hpe: Int,
    val employeeValue: Double,

    // CSP Hardware savings
    val vmCount: Int,
    val connectorCount: Int,
    val tcoPerVm: Double,
) {
    fun hoursSaved(): Int {
        return envCount * hpe
    }

    fun vmsSaved(): Int {
        return (vmCount * envCount) - (connectorCount * envCount)
    }

    fun licenseCostDifferencePerUser(): Double {
        return cocc - copl
    }

    fun operationalSavings(): Double {
        return hoursSaved() * employeeValue
    }

    fun hardwareSavings(): Double {
        return vmsSaved() * tcoPerVm
    }

    fun licenseCost(): Double {
        return userCount * licenseCostDifferencePerUser()
    }

    fun totalCloudSavings() : Double {
        return operationalSavings() + hardwareSavings() - licenseCost()
    }
}
