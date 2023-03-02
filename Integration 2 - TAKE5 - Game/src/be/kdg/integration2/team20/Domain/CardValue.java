package be.kdg.integration2.team20.Domain;

import java.util.Random;

public enum CardValue {
    CARD1(1, 1), CARD2(2, 1), CARD3(3, 1), CARD4(4, 1), CARD5(5, 2),
    CARD6(6, 1), CARD7(7, 1), CARD8(8, 1), CARD9(9, 1), CARD10(10, 3),
    CARD11(11, 7), CARD12(12, 1), CARD13(13, 1), CARD14(14, 1), CARD15(15, 2),
    CARD16(16, 1), CARD17(17, 1), CARD18(18, 1), CARD19(19, 1), CARD20(20, 3),
    CARD21(21, 1), CARD22(22, 7), CARD23(23, 1), CARD24(24, 1), CARD25(25, 2),
    CARD26(26, 1), CARD27(27, 1), CARD28(28, 1), CARD29(29, 1), CARD30(30, 3),
    CARD31(31, 1), CARD32(32, 1), CARD33(33, 7), CARD34(34, 1), CARD35(35, 2),
    CARD36(36, 1), CARD37(37, 1), CARD38(38, 1), CARD39(39, 1), CARD40(40, 3),
    CARD41(41, 1), CARD42(42, 1), CARD43(43, 1), CARD44(44, 7), CARD45(45, 2),
    CARD46(46, 1), CARD47(47, 1), CARD48(48, 1), CARD49(49, 1), CARD50(50, 3),
    CARD51(51, 1), CARD52(52, 1), CARD53(53, 1), CARD54(54, 1), CARD55(55, 7),
    CARD56(56, 1), CARD57(57, 1), CARD58(58, 1), CARD59(59, 1), CARD60(60, 3),
    CARD61(61, 1), CARD62(62, 1), CARD63(63, 1), CARD64(64, 1), CARD65(65, 2),
    CARD66(66, 7), CARD67(67, 1), CARD68(68, 1), CARD69(69, 1), CARD70(70, 3),
    CARD71(71, 1), CARD72(72, 1), CARD73(73, 1), CARD74(74, 1), CARD75(75, 2),
    CARD76(76, 1), CARD77(77, 7), CARD78(78, 1), CARD79(79, 1), CARD80(80, 3),
    CARD81(81, 1), CARD82(81, 1), CARD83(83, 1), CARD84(84, 1), CARD85(85, 2),
    CARD86(86, 1), CARD87(87, 1), CARD88(88, 7), CARD89(89, 1), CARD90(90, 3),
    CARD91(91, 1), CARD92(92, 1), CARD93(93, 1), CARD94(94, 1), CARD95(95, 2),
    CARD96(96, 1), CARD97(97, 1), CARD98(98, 1), CARD99(99, 7), CARD100(100, 3),
    CARD101(101, 1), CARD102(102, 1), CARD103(103, 1), CARD104(104, 1);


    private int value;
    private int amountOfBulls;

    CardValue(int value, int amountOfBulls) {
        this.value = value;
        this.amountOfBulls = amountOfBulls;
    }

    public int getValue() {
        return value;
    }

    public int getPointValue() {
        if (value % 5 == 0) {
            this.amountOfBulls += 2;    //why += and not just =
        }
        if (value % 10 == 0) {
            this.amountOfBulls += 1;
        }
        if (value % 11 == 0) {
            this.amountOfBulls += 5;
        }
        if (amountOfBulls == 0)
            this.amountOfBulls = 1;
        System.out.println("PointValue is " + amountOfBulls);

        return 0;
    }
}
