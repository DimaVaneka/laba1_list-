package Task1;

//Реализация двунаправленного списка (Dmitry Vaneka)
public class MyLinkedListValue {
    public Node<Polenom> head;//Головной элемент
    private Node<Polenom> tail;//Конечный элемент
    private int numElements;//Размерность

    //Конструктор для инициализации элементов
    public MyLinkedListValue() {
        this.head = null;
        this.tail = null;
        this.numElements = 0;
    }

    //Добавление элемента в начало списка
    public void addFirst(Polenom e) {
        // создаем новый узел с данными "e", а следующий и предыдущий значения равны NULL.
        Node<Polenom> temp = new Node<>(e, null, null);

        //Если список пуст
        if (head == null) {
            //Присваеваем головному и конечному узлу ссылку на только что созданный нами узел
            head = temp;
            tail = temp;

        }
        //в противном случае устанавливаем следующим элементом  нового узла заголовок, а предыдущим элементом зоголовка новый узел
        else {
            temp.setNext(head);//Следующим узлом нового узла устанавливем старый заголовок
            head.setPrevious(temp);// Предыдущим узлом старого заголовка устанавливаем новый узел
            head = temp;//К заголовку списка устанавлиаем ссылку на новый узел
        }
        numElements++;//Инкрементируем размерность списка

    }

    //Добавлеие элемента в конец списка
    public void addLast(Polenom e) {
        // создаем новый узел с данными "e", а следующий и предыдущий элемент  NULL.
        Node<Polenom> temp = new Node<>(e, null, null);
        //Если список пуст
        if (head == null) {
            //Присваеваем головному и конечному узлу ссылку на только что созданный нами узел
            tail = temp;
            head = temp;
        } else {
            tail.setNext(temp);//Задаем хвосту следующим элементом только что созданый нами узел
            temp.setPrevious(tail);//Задаем новому узлу предыдущим элементом хвост
            tail = temp;// Хвосту присваиваем ссылку на новый узел
        }
        numElements++;//Инкрементируем размерность списка
    }

    //Удаление первого элемента в списке
    public Polenom removeFirst() {
        //Если список пуст кидает исключение
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Polenom answer = head.getData();//Получаем данные у первого элемента в списке
        head = head.getNext();//Присваиеваем заголовку 2-ой элемент в списке
        if (head != null) {
            head.setPrevious(null);//У заголовка не должно быть предыдущего элемента
        }
        numElements--; //Декрементируем  размерность
        return answer;
    }

    //Удаление последнего элемента в списке
    public Polenom removeLast() {
        //Если список пуст, то кидает исключение
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        //Получаем данные хвоста
        Polenom answer = tail.getData();
        //Переопределяем  ховст на предыдущий элемент в списке
        tail = tail.getPrevious();
        //Устанавливаем null следующему элементу хвоста
        if (tail != null) {
            tail.setNext(null);
        }

        numElements--;//Декрементируем размерность списка
        return answer;
    }

    public boolean add(Polenom e) {
        addLast((Polenom) e);
        return true;
    }

    //Добавление элемента по индексу
    public void add(int index, Polenom element) {
        //Если элемента с указаным индексом нет в списке, то кидаем исключение
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        //Если добавление в список первое
        if (index == 0) {
            addFirst((Polenom) element);//Используем метод для добавлени в начало списка
        } else if (index == size() - 1) //Если индекс указанного элемента последний в списке
        {
            addLast((Polenom) element);//Используем метод для добавлени в конец списка
        } else {
            Node<Polenom> firstElement = head;//1-ый элемент в списке
            //Доходим до предыдущего элемента искомого нами индекса и устанавливаем в firstElement
            for (int i = 0; i < index - 1; i++) {
                firstElement = firstElement.getNext();//доходим до элемента
            }
            Node<Polenom> endElement = firstElement.getNext();//Элемент искомого нами индекса
            Node<Polenom> newElement = new Node<Polenom>(element, endElement, firstElement);//Создаем новый узел, в котором указываем следующий и предыдущий узел
            firstElement.setNext(newElement);//Устанавливаем элементу под индексом [index-1] следующим элементом новый узел
            endElement.setPrevious(newElement);///Устанавливаем элементу под индексом [index+1] предыдущим элементом новый узел
            numElements++;//Инкрементируем размерность
        }
    }

    public void clear() {
        numElements = 0;
        head = null;
        tail = null;
    }

    //Возваращает данные элемента по индексу
    public Polenom get(int index) {
        //Если индекс не вписывается в пределы нашего списка,то кидаем исключение
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        return marchToIndex(index).getData();
    }

    //Устанавливаем новое значение по индексу
    public Polenom set(int index, Polenom element) {
        //Если индекс не вписывается в пределы нашего списка,то кидаем исключение
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        //Получаем искомый элемент
        Node<Polenom> iter = marchToIndex(index);
        //Получаем его данные
        Polenom old = iter.getData();
        //Устанавливаем новые данные
        iter.setData((Polenom) element);
        return old;
    }




    public boolean isEmpty() {
        return size() == 0;
    }


    //Метод используется для удаления определенного элемента из набора
    public Polenom remove(int index) {
        //Если индекс не вписывается в пределы нашего списка,то кидаем исключение
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();//Используем метод для удаления первого элемента
        }else if (index == size() - 1) {
            return removeLast();//Используем метод для удаления последнего элемента
        } else {
            //Находим элемент нужнего индекса и ссыламаем его на переменную  iter
            Node<Polenom> iter = marchToIndex(index);
            Polenom old = iter.getData();
            iter.getPrevious().setNext(iter.getNext());//Устанавливаем элементу под индексом index-1 ссылку на следующим элемент под индексом index +1
            iter.getNext().setPrevious(iter.getPrevious());//Устанавливаем элементу под индексом index+1 ссылку на прредыдущий элемент под индексом index - 1
            numElements--;//Декрементируем ращмерность списка
            return old;
        }
    }

    //Метод, который возвращает размерность списка
    public int size() {
        return numElements;
    }

    //Метод ,который проверяет входит ли поданный нами индекс в границы списка. Если не входит, то возвращает false. Входит - true
    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= size();
    }

    //Метод который возвращает нужный узел по индексу
    private Node<Polenom> marchToIndex(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<Polenom> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

}