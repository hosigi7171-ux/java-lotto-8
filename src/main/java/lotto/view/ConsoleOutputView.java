package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class ConsoleOutputView implements OutputView{

    public void printLottos(List<Lotto> lottos){
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
