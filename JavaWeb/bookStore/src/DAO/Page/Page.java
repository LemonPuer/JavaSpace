package DAO.Page;

import DAO.Book.Book;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-26-12:06
 */
public class Page<T> {
    public static final int NOTECOUNT=4;
    //当前页码
    private int pageNo;
    //页码总数
    private int allPage;
    //显示消息数
    private int note=NOTECOUNT;
    //消息总数
    private int allNote;
    //消息数据
    private List<T> noteData;

    public Page() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getAllNote() {
        return allNote;
    }

    public void setAllNote(int allNote) {
        this.allNote = allNote;
    }

    public List getNoteData() {
        return noteData;
    }

    public void setNoteData(List noteData) {
        this.noteData = noteData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", allPage=" + allPage +
                ", note=" + note +
                ", allNote=" + allNote +
                ", noteData=" + noteData +
                '}';
    }
}
