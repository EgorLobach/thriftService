/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package aipos.model;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2018-03-20")
public class Book implements org.apache.thrift.TBase<Book, Book._Fields>, java.io.Serializable, Cloneable, Comparable<Book> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Book");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField YEAR_OF_PUBLICATION_FIELD_DESC = new org.apache.thrift.protocol.TField("yearOfPublication", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField CHAPTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("chapters", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BookStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BookTupleSchemeFactory());
  }

  public String name; // required
  public long yearOfPublication; // required
  public aipos.model.Author author; // required
  public List<aipos.model.Chapter> chapters; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    YEAR_OF_PUBLICATION((short)2, "yearOfPublication"),
    AUTHOR((short)3, "author"),
    CHAPTERS((short)4, "chapters");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // YEAR_OF_PUBLICATION
          return YEAR_OF_PUBLICATION;
        case 3: // AUTHOR
          return AUTHOR;
        case 4: // CHAPTERS
          return CHAPTERS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __YEAROFPUBLICATION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.YEAR_OF_PUBLICATION, new org.apache.thrift.meta_data.FieldMetaData("yearOfPublication", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, aipos.model.Author.class)));
    tmpMap.put(_Fields.CHAPTERS, new org.apache.thrift.meta_data.FieldMetaData("chapters", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, aipos.model.Chapter.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Book.class, metaDataMap);
  }

  public Book() {
  }

  public Book(
    String name,
    long yearOfPublication,
    aipos.model.Author author,
    List<aipos.model.Chapter> chapters)
  {
    this();
    this.name = name;
    this.yearOfPublication = yearOfPublication;
    setYearOfPublicationIsSet(true);
    this.author = author;
    this.chapters = chapters;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Book(Book other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.yearOfPublication = other.yearOfPublication;
    if (other.isSetAuthor()) {
      this.author = new aipos.model.Author(other.author);
    }
    if (other.isSetChapters()) {
      List<aipos.model.Chapter> __this__chapters = new ArrayList<aipos.model.Chapter>(other.chapters.size());
      for (aipos.model.Chapter other_element : other.chapters) {
        __this__chapters.add(new aipos.model.Chapter(other_element));
      }
      this.chapters = __this__chapters;
    }
  }

  public Book deepCopy() {
    return new Book(this);
  }

  @Override
  public void clear() {
    this.name = null;
    setYearOfPublicationIsSet(false);
    this.yearOfPublication = 0;
    this.author = null;
    this.chapters = null;
  }

  public String getName() {
    return this.name;
  }

  public Book setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public long getYearOfPublication() {
    return this.yearOfPublication;
  }

  public Book setYearOfPublication(long yearOfPublication) {
    this.yearOfPublication = yearOfPublication;
    setYearOfPublicationIsSet(true);
    return this;
  }

  public void unsetYearOfPublication() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __YEAROFPUBLICATION_ISSET_ID);
  }

  /** Returns true if field yearOfPublication is set (has been assigned a value) and false otherwise */
  public boolean isSetYearOfPublication() {
    return EncodingUtils.testBit(__isset_bitfield, __YEAROFPUBLICATION_ISSET_ID);
  }

  public void setYearOfPublicationIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __YEAROFPUBLICATION_ISSET_ID, value);
  }

  public aipos.model.Author getAuthor() {
    return this.author;
  }

  public Book setAuthor(aipos.model.Author author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  public int getChaptersSize() {
    return (this.chapters == null) ? 0 : this.chapters.size();
  }

  public java.util.Iterator<aipos.model.Chapter> getChaptersIterator() {
    return (this.chapters == null) ? null : this.chapters.iterator();
  }

  public void addToChapters(aipos.model.Chapter elem) {
    if (this.chapters == null) {
      this.chapters = new ArrayList<aipos.model.Chapter>();
    }
    this.chapters.add(elem);
  }

  public List<aipos.model.Chapter> getChapters() {
    return this.chapters;
  }

  public Book setChapters(List<aipos.model.Chapter> chapters) {
    this.chapters = chapters;
    return this;
  }

  public void unsetChapters() {
    this.chapters = null;
  }

  /** Returns true if field chapters is set (has been assigned a value) and false otherwise */
  public boolean isSetChapters() {
    return this.chapters != null;
  }

  public void setChaptersIsSet(boolean value) {
    if (!value) {
      this.chapters = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case YEAR_OF_PUBLICATION:
      if (value == null) {
        unsetYearOfPublication();
      } else {
        setYearOfPublication((Long)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((aipos.model.Author)value);
      }
      break;

    case CHAPTERS:
      if (value == null) {
        unsetChapters();
      } else {
        setChapters((List<aipos.model.Chapter>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case YEAR_OF_PUBLICATION:
      return getYearOfPublication();

    case AUTHOR:
      return getAuthor();

    case CHAPTERS:
      return getChapters();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case YEAR_OF_PUBLICATION:
      return isSetYearOfPublication();
    case AUTHOR:
      return isSetAuthor();
    case CHAPTERS:
      return isSetChapters();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Book)
      return this.equals((Book)that);
    return false;
  }

  public boolean equals(Book that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_yearOfPublication = true;
    boolean that_present_yearOfPublication = true;
    if (this_present_yearOfPublication || that_present_yearOfPublication) {
      if (!(this_present_yearOfPublication && that_present_yearOfPublication))
        return false;
      if (this.yearOfPublication != that.yearOfPublication)
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_chapters = true && this.isSetChapters();
    boolean that_present_chapters = true && that.isSetChapters();
    if (this_present_chapters || that_present_chapters) {
      if (!(this_present_chapters && that_present_chapters))
        return false;
      if (!this.chapters.equals(that.chapters))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_yearOfPublication = true;
    list.add(present_yearOfPublication);
    if (present_yearOfPublication)
      list.add(yearOfPublication);

    boolean present_author = true && (isSetAuthor());
    list.add(present_author);
    if (present_author)
      list.add(author);

    boolean present_chapters = true && (isSetChapters());
    list.add(present_chapters);
    if (present_chapters)
      list.add(chapters);

    return list.hashCode();
  }

  @Override
  public int compareTo(Book other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetYearOfPublication()).compareTo(other.isSetYearOfPublication());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetYearOfPublication()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.yearOfPublication, other.yearOfPublication);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthor()).compareTo(other.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, other.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChapters()).compareTo(other.isSetChapters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChapters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.chapters, other.chapters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Book(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("yearOfPublication:");
    sb.append(this.yearOfPublication);
    first = false;
    if (!first) sb.append(", ");
    sb.append("author:");
    if (this.author == null) {
      sb.append("null");
    } else {
      sb.append(this.author);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("chapters:");
    if (this.chapters == null) {
      sb.append("null");
    } else {
      sb.append(this.chapters);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (author != null) {
      author.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BookStandardSchemeFactory implements SchemeFactory {
    public BookStandardScheme getScheme() {
      return new BookStandardScheme();
    }
  }

  private static class BookStandardScheme extends StandardScheme<Book> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // YEAR_OF_PUBLICATION
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.yearOfPublication = iprot.readI64();
              struct.setYearOfPublicationIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.author = new aipos.model.Author();
              struct.author.read(iprot);
              struct.setAuthorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CHAPTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.chapters = new ArrayList<aipos.model.Chapter>(_list0.size);
                aipos.model.Chapter _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new aipos.model.Chapter();
                  _elem1.read(iprot);
                  struct.chapters.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setChaptersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Book struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(YEAR_OF_PUBLICATION_FIELD_DESC);
      oprot.writeI64(struct.yearOfPublication);
      oprot.writeFieldEnd();
      if (struct.author != null) {
        oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
        struct.author.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.chapters != null) {
        oprot.writeFieldBegin(CHAPTERS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.chapters.size()));
          for (aipos.model.Chapter _iter3 : struct.chapters)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BookTupleSchemeFactory implements SchemeFactory {
    public BookTupleScheme getScheme() {
      return new BookTupleScheme();
    }
  }

  private static class BookTupleScheme extends TupleScheme<Book> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetYearOfPublication()) {
        optionals.set(1);
      }
      if (struct.isSetAuthor()) {
        optionals.set(2);
      }
      if (struct.isSetChapters()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetYearOfPublication()) {
        oprot.writeI64(struct.yearOfPublication);
      }
      if (struct.isSetAuthor()) {
        struct.author.write(oprot);
      }
      if (struct.isSetChapters()) {
        {
          oprot.writeI32(struct.chapters.size());
          for (aipos.model.Chapter _iter4 : struct.chapters)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.yearOfPublication = iprot.readI64();
        struct.setYearOfPublicationIsSet(true);
      }
      if (incoming.get(2)) {
        struct.author = new aipos.model.Author();
        struct.author.read(iprot);
        struct.setAuthorIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.chapters = new ArrayList<aipos.model.Chapter>(_list5.size);
          aipos.model.Chapter _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new aipos.model.Chapter();
            _elem6.read(iprot);
            struct.chapters.add(_elem6);
          }
        }
        struct.setChaptersIsSet(true);
      }
    }
  }

}

