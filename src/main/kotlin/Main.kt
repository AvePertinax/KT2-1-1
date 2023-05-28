enum class PaymentSystem {
    VISA, MIR, MASTERCARD, MAESTRO, VK
}

fun calcPaymentCommission(
    amount: Int, paymentSystem: PaymentSystem = PaymentSystem.VK, amountOfTransfersThisMonth: Int = 0
): Int {
    return when (paymentSystem) {
        PaymentSystem.MASTERCARD, PaymentSystem.MAESTRO -> {
            if (amount > 300 && amountOfTransfersThisMonth < 75000) 0
            else (amount * 0.006 + 20).toInt()
        }
        PaymentSystem.VISA, PaymentSystem.MIR -> {
            if (amount * 0.0075 < 35) 35 else (amount * 0.0075).toInt()
        }
        PaymentSystem.VK -> {
            0
        }
    }
}

fun main() {
    println(calcPaymentCommission(550, PaymentSystem.VISA))
    println(calcPaymentCommission(420, PaymentSystem.MAESTRO))
    println(calcPaymentCommission(420, PaymentSystem.MAESTRO, 80000))
    println(calcPaymentCommission(420, PaymentSystem.MAESTRO, 50000))
    println(calcPaymentCommission(2781, PaymentSystem.VK))
}