package be.kdg.integration2.take5.model;

public enum Card {
    CARD1(1), CARD2(2), CARD3(3), CARD4(4), CARD5(5),
    CARD6(6), CARD7(7), CARD8(8), CARD9(9), CARD10(10),
    CARD11(11), CARD12(12), CARD13(13), CARD14(14), CARD15(15),
    CARD16(16), CARD17(17), CARD18(18), CARD19(19), CARD20(20),
    CARD21(21), CARD22(22), CARD23(23), CARD24(24), CARD25(25),
    CARD26(26), CARD27(27), CARD28(28), CARD29(29), CARD30(30),
    CARD31(31), CARD32(32), CARD33(33), CARD34(34), CARD35(35),
    CARD36(36), CARD37(37), CARD38(38), CARD39(39), CARD40(40),
    CARD41(41), CARD42(42), CARD43(43), CARD44(44), CARD45(45),
    CARD46(46), CARD47(47), CARD48(48), CARD49(49), CARD50(50),
    CARD51(51), CARD52(52), CARD53(53), CARD54(54), CARD55(55),
    CARD56(56), CARD57(57), CARD58(58), CARD59(59), CARD60(60),
    CARD61(61), CARD62(62), CARD63(63), CARD64(64), CARD65(65),
    CARD66(66), CARD67(67), CARD68(68), CARD69(69), CARD70(70),
    CARD71(71), CARD72(72), CARD73(73), CARD74(74), CARD75(75),
    CARD76(76), CARD77(77), CARD78(78), CARD79(79), CARD80(80),
    CARD81(81), CARD82(81), CARD83(83), CARD84(84), CARD85(85),
    CARD86(86), CARD87(87), CARD88(88), CARD89(89), CARD90(90),
    CARD91(91), CARD92(92), CARD93(93), CARD94(94), CARD95(95),
    CARD96(96), CARD97(97), CARD98(98), CARD99(99), CARD100(100),
    CARD101(101), CARD102(102), CARD103(103), CARD104(104);

    private final int value;

    Card(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " " + value;
    }

    public static Card withValue(int index) {
        return Card.values()[index - 1];
        //check that index between 1 and length
    }

    public static int getPointValue(Card card) {
        if (card.getValue() % 10 == 0) {
            return 3;
        } else if (card.getValue() % 55 == 0) {
            return 7;
        } else if (card.getValue() % 5 == 0) {
            return 2;
        } else if (card.getValue() % 11 == 0) {
            return 5;
        } else {
            return 1;
        }
    } //throw exception if number entered

}

