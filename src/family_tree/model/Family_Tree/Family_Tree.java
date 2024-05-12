package family_tree.model.Family_Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import family_tree.model.Human.Comparator.HumanComparatorByDob;
import family_tree.model.Human.Comparator.HumanComparatorByName;
import family_tree.model.Human.Comparator.HumanComparatorByPlaceOfBirth;

import java.util.Iterator;
/* 
 * Класс для описания генеалогического древа
 */
public class Family_Tree<E extends Node<E>> implements Serializable, Iterable<E>{

    private List<E> humanList;

    public Family_Tree() 
    {
         this(new ArrayList<>());
    }

    public Family_Tree(List<E> humanList) 
    { 
        this.humanList = humanList; 
    }

    /*
     * Добавляет нового члена в древо
     */
    public boolean add(E human)
    {
        if (human == null) return false;
        if (!humanList.contains(human))
        {
            humanList.add(human);
            return true;
        }
        else return false;
    }
    
/*
 * метод позволяющий найти отдельного человека в древе
 */
    // public E getByName(String name)
    // {
    //     for (E human: humanList)
    //     {
    //         if (human.getName().equals(name)) return human;
    //     }
    //     return null;
    // }
/*
 * Вывод всех членов древа
 */
    public String getData()
    {
        StringBuilder info = new StringBuilder();
        info.append("В генеалогическим дереве: ");
        info.append(humanList.size());
        info.append(" объектов. \n");
        int i =1;
        for (E human: humanList)
        {   
            info.append(i);
            info.append('.');
            info.append(' ');
            info.append(human.getData());
            info.append("\n");
            i++;
        }
        return info.toString();
    }

    public void sortByName(){humanList.sort(new HumanComparatorByName<>());}

    public void sortByDob(){humanList.sort(new HumanComparatorByDob<>());}

    public void sortByPlaceOfBirth(){humanList.sort(new HumanComparatorByPlaceOfBirth<>());}

    @Override
    public Iterator<E> iterator() {
        return new Family_TreeIterator(humanList);
    }


}
