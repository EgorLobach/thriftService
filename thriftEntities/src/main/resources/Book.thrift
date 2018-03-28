namespace java aipos.model

include "Author.thrift"
include "Chapter.thrift"

struct Book {
    1: string name
    2: i64 yearOfPublication
    3: Author.Author author
    4: list<Chapter.Chapter> chapters
}