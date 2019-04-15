// Copyright(C) 2000-2003 Yoshinori Oota All rights reserved.

public class ProxySample
{
    static Subject Create()
    {
        return new ProxySubject();
    }
    static public void main(String[] args)
    {
        Subject subject = Create();
        subject.Request();
        subject.Request();
    }
}

abstract class Subject
{
    abstract public void Request();
}

class RealSubject extends Subject
{
    private String _str = "very long text -------->";
    public void Request()
    {
        System.out.println(_str);
    }
}

class ProxySubject extends Subject
{
    private RealSubject _subject = null;
    public void Request()
    {
        if (_subject == null)
        {
            System.out.print("(please wait...)   ");
            _subject = new RealSubject();
        }
        _subject.Request();
    }
}
