package net.pearx.purmag.client.guis.controls;

import java.util.*;

/**
 * Created by mrAppleXZ on 16.04.17 13:12.
 */
public class ControlList implements List<Control>
{
    private ArrayList<Control> lst = new ArrayList<>();

    public Control parent;

    public ControlList(Control parent)
    {
        this.parent = parent;
    }

    @Override
    public int size()
    {
        return lst.size();
    }

    @Override
    public boolean isEmpty()
    {
        return lst.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return lst.contains(o);
    }

    @Override
    public Iterator<Control> iterator()
    {
        return lst.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return lst.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts)
    {
        return lst.toArray(ts);
    }

    @Override
    public boolean add(Control control)
    {
        control.setParent(parent);
        return lst.add(control);
    }

    @Override
    public boolean remove(Object o)
    {
        if(o instanceof Control)
            ((Control)o).setParent(null);
        return lst.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return lst.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends Control> collection)
    {
        for (Control c : collection)
            c.setParent(parent);
        return lst.addAll(collection);
    }

    @Override
    public boolean addAll(int i, Collection<? extends Control> collection)
    {
        for (Control c : collection)
            c.setParent(parent);
        return lst.addAll(i, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection)
    {
        for(Object o : collection)
            if(o instanceof Control)
                ((Control)o).setParent(null);
        return lst.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection)
    {
        for(Control c : this)
        {
            if(!collection.contains(c))
            {
                c.setParent(null);
            }
        }
        return lst.retainAll(collection);
    }

    @Override
    public void clear()
    {
        for (Control c : this)
            c.setParent(null);
        lst.clear();
    }

    @Override
    public Control get(int i)
    {
        return lst.get(i);
    }

    @Override
    public Control set(int i, Control control)
    {
        get(i).setParent(null);
        control.setParent(parent);
        return lst.set(i, control);
    }

    @Override
    public void add(int i, Control control)
    {
        control.setParent(parent);
        lst.add(i, control);
    }

    @Override
    public Control remove(int i)
    {
        get(i).setParent(null);
        return lst.remove(i);
    }

    @Override
    public int indexOf(Object o)
    {
        return lst.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return lst.lastIndexOf(o);
    }

    @Override
    public ListIterator<Control> listIterator()
    {
        return lst.listIterator();
    }

    @Override
    public ListIterator<Control> listIterator(int i)
    {
        return lst.listIterator(i);
    }

    @Override
    public List<Control> subList(int i, int i1)
    {
        return lst.subList(i, i1);
    }
}