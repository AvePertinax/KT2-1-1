import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcPaymentCommissionDefault() {
        assertEquals(calcPaymentCommission(10), 0)
        assertEquals(calcPaymentCommission(100), 0)
        assertEquals(calcPaymentCommission(1000), 10)
        assertEquals(calcPaymentCommission(10000), 0)
        assertEquals(calcPaymentCommission(100000), 0)
    }

    @Test
    fun calcPaymentCommissionVisaMir() {
        assertEquals(calcPaymentCommission(1000, PaymentSystem.VISA), 35)
        assertEquals(calcPaymentCommission(10000, PaymentSystem.VISA), 75)
    }

    @Test
    fun calcPaymentCommissionMaestroMastercard() {
        assertEquals(calcPaymentCommission(100, PaymentSystem.MAESTRO, 1000), 20)
        assertEquals(calcPaymentCommission(100, PaymentSystem.MAESTRO, 10000), 20)
        assertEquals(calcPaymentCommission(100, PaymentSystem.MAESTRO, 80000), 20)
        assertEquals(calcPaymentCommission(1000, PaymentSystem.MAESTRO, 1000), 0)
        assertEquals(calcPaymentCommission(1000, PaymentSystem.MAESTRO, 10000), 0)
        assertEquals(calcPaymentCommission(1000, PaymentSystem.MAESTRO, 80000), 26)
    }


}
