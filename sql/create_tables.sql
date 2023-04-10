CREATE TABLE "reviews" (
                           id bigserial not null
                               constraint reviews_pkey
                                   primary key,
                           book_id int not null,
                           rating int not null,
                           description varchar(2000),
                           created_at timestamp
);