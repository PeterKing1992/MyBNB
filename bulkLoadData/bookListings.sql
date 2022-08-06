-- Justin Bieber Toronto 1
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2009-06-04'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-04'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-05'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-06'); 
-- Justin Bieber Toronto Cancel 1
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber Toronto 2
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 2, '2023-06-04'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 2, '2023-06-05'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 2, '2023-06-06'); 

-- Justin Bieber New York 1
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 1
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber Toronto 3
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-04'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-05'); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 1, '2021-06-06'); 

-- Justin Bieber New York 2
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 2
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 3
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 3
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 4
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 4
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 5
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 5
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 6
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 6
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 7
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 7
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW())); 

-- Justin Bieber New York 8
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 8
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 9
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
-- Justin Bieber New York Cancel 9
INSERT INTO renterCancelBooking(SIN, bid, cancelDate) VALUES('118766990', last_insert_id(), DATE(NOW()));  

-- Justin Bieber New York 10 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 11 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 10 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 11 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 10 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 11 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 12 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber New York 13 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  
-- Justin Bieber New York 14 Being Cancelled
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2022-06-04'); 
INSERT INTO hostCancelBooking(bid, SIN, CancelDate) VALUES(last_insert_id(), '879223766', DATE(NOW()));  

-- Justin Bieber Richmond Hill 1
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 3, '2022-06-04'); 
-- Justin Bieber Richmond Hill 2
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 2, '2022-06-04'); 
-- Justin Bieber Richmond Hill 3
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 3, '2023-09-10'); 

-- Justin Bieber Comment On Richmond Hill
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('118766990', 3, DATE(NOW()), 5, 'Very Nice House Close to libraries Definitely Recomment'); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 3, DATE(NOW()), 3, 'Wonderland was so good Such a place to checkout '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 3, DATE(NOW()), 3, 'I prefer more restaurants'); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 3, DATE(NOW()), 4, 'Nice House terrible restaurants around it though'); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 3, DATE(NOW()), 4, 'Nice House but restaurants around it are so bad'); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 3, DATE(NOW()), 4, 'Very Nice house Cinema is not far away either '); 
-- Justin Bieber Comment On Toronto
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('118766990', 1, DATE(NOW()), 5, 'Close to UofT if you like reading you will love it '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('118766990', 1, DATE(NOW()), 3, 'Actually, was not as good as I found it last time. Dirty roofs noisy street I do not like it '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 1, DATE(NOW()), 5, 'It was an okay experience, as long as you have headphones because the street is too noisy '); 

INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 1, DATE(NOW()), 5, 'Noisy street but UofT library is so good '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 1, DATE(NOW()), 4.5, 'Nice library and nice house '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 1, DATE(NOW()), 4.5, 'Nice house nice yard super spatious definitely recommend '); 
INSERT INTO renterCommentOnListing(renter, lid, commentDate, rating, content) VALUES('816886265', 1, DATE(NOW()), 4.3, 'Houses are generally old around here. I feel like this house is definitely a lot nicer Yard is very spatious, you can do anything in it '); 

-- Justin Bieber Beijing
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 23, '2023-06-08'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 23, '2023-06-09'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 23, '2023-06-07'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 24, '2023-06-08'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 24, '2023-06-09'); 

-- Justin Bieber New York Success
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2023-06-04'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '118766990', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 20, '2023-06-08'); 

-- Neo Red New York 1
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '718001891', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 21, '2023-06-06'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '718001891', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 21, '2023-06-07'); 

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '718001891', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 21, '2023-06-08'); 

-- Neo Red Beijing 
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '718001891', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 23, '2023-06-06');

INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '718001891', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 25, '2023-06-08'); 

-- Some Renter Beijing
INSERT INTO booking VALUES(null); 
INSERT INTO renterBookBooking(bid, SIN, bookDate) VALUES(last_insert_id(), '816886265', DATE(NOW())); 
INSERT INTO bookingAssociatedWithOffering(bid, lid, offeringDate) VALUES(last_insert_id(), 25, '2023-06-09'); 

