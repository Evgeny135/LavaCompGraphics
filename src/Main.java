import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.BorderLayout.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Window");
        jFrame.setSize(800,600);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));

        //Создание шапки(меню)
        JMenuBar jMenu = new JMenuBar();

        //Создание поле меню "Файл"
        JMenu file = new JMenu("Файл");
        file.add(new JMenuItem("Открыть"));
        file.add(new JMenuItem("Выход"));

        // Создание поле меню "Вид"
        JMenu view = new JMenu("Вид");
        // Переключатели
        JRadioButtonMenuItem grid = new JRadioButtonMenuItem("Сетка");
        JRadioButtonMenuItem line = new JRadioButtonMenuItem("Линия");
        // организуем переключатели в логическую группу
        ButtonGroup bg = new ButtonGroup();
        bg.add(grid);
        bg.add(line);

        grid.setSelected(true);

        //Добавление в "Вид"
        view.add(line);
        view.add(grid);
        //Добавление в JMenu
        jMenu.add(file);
        jMenu.add(view);


        //Создание панельки инструементов
        JPanel tools = new JPanel();
        tools.setLayout(new BorderLayout());
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton("Ножницы"));
//        toolBar.add(new ImageIcon(""));
        toolBar.addSeparator();
        toolBar.add(new JButton("Заливка"));
        toolBar.addSeparator();
        toolBar.add(new JButton("Пипетка"));

        String[] items = {"Тест 1", "Тест 2", "Тест 3"};

        // Добавление менюшки с выбором
        toolBar.add(new JComboBox<String>(items));
        // Блокируем возможность перетаскивания панели
        toolBar.setFloatable(false);

        //Добавим левую панельку
        JPanel resizablePanel = new JPanel();

        // Добавим панельку со вкладками
        JTabbedPane jTabbedPane = new JTabbedPane();

        // Панелька с радио кнопками
        JPanel radioMenu = new JPanel();
        radioMenu.setLayout(new BoxLayout(radioMenu,BoxLayout.Y_AXIS));

        JLabel jLabel = new JLabel("Куда доставить посылку:");
        JRadioButtonMenuItem one = new JRadioButtonMenuItem("Частный дом");
        JRadioButtonMenuItem two = new JRadioButtonMenuItem("Квартира");

        // Обьединение в логическую группу
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(one);
        buttonGroup.add(two);

        radioMenu.add(jLabel,radioMenu);
        radioMenu.add(one,radioMenu);
        radioMenu.add(two, radioMenu);

        JPanel checkMenu = new JPanel();
        checkMenu.setLayout(new BorderLayout());

        JCheckBox jCheckBox = new JCheckBox();

        jCheckBox.setLayout(new BoxLayout(jCheckBox,BoxLayout.Y_AXIS));

        jCheckBox.add(new JCheckBoxMenuItem("Тест1"));
        jCheckBox.add(new JCheckBoxMenuItem("Тест2"));
        jCheckBox.add(new JCheckBoxMenuItem("Тест3"));

        checkMenu.add(jCheckBox,CENTER);

        //Вкладка формы
        JPanel formMenu = new JPanel();
        formMenu.setLayout(new BorderLayout());

        JPanel label1 = new JPanel();
        JLabel nameLabel = new JLabel("Ваше имя: ");
        label1.add(nameLabel);

        JTextField textName = new JTextField(15);
        formMenu.add(textName,CENTER);
        label1.add(textName);

        JPanel jPanel2 = new JPanel();

        JLabel lastName = new JLabel("Ваше фамилия: ");
        jPanel2.add(lastName,CENTER);

        JTextField textLastName = new JTextField(15);
        jPanel2.add(textLastName,CENTER);

        // Добавление скроллбара
        JScrollBar hBar = new JScrollBar(Adjustable.HORIZONTAL);
        JScrollBar vBar = new JScrollBar(Adjustable.VERTICAL);

        formMenu.add(hBar,SOUTH);
        formMenu.add(vBar,EAST);
        formMenu.add(label1,NORTH);
        formMenu.add(jPanel2,CENTER);

        jTabbedPane.addTab("Радио кнопка",radioMenu);
        jTabbedPane.addTab("Выбор кнопка",checkMenu);
        jTabbedPane.addTab("Форма",formMenu);


        tools.add(toolBar,WEST);

        jFrame.setJMenuBar(jMenu);
        jFrame.add(tools,NORTH);
        // Разделение экрана 2 части с сдвигающейся границей
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,resizablePanel,jTabbedPane);
        jFrame.add(jSplitPane);


        jFrame.setVisible(true);
    }
}
