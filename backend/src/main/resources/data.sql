INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    1,
    'Chambre Première',
    'Calm and luminous rooms ideal for a short stay. Contemporary decoration with marble bathrooms.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    2,
    'Chambre Deluxe',
    'Different options offering peace and quiet: single-floor or duplex rooms with marble bathrooms.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    3,
    'Chambre Deluxe Tour Eiffel',
    'Rooms with partial views of the Eiffel Tower, perfect for a romantic getaway.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    4,
    'Junior Suite',
    'Rooms with a separate living room, ideal for long stays. Contemporary decor.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    5,
    'Chambre Prestige Tour Eiffel',
    'Bright rooms with partial views of the Eiffel Tower and luxurious Art Deco balconies.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    6,
    'Suite Prestige',
    'Spacious and luxurious suites with Parisian-style decor, separate living room, and dressing room.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    7,
    'Suite Terrasse Eiffel',
    'Suites with private terraces offering stunning views of the Eiffel Tower.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    8,
    'Suite Marignan Eiffel',
    'Elegant suites with terraces and panoramic views of the Eiffel Tower.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    9,
    'Chambre Familiale',
    'Rooms ideal for families, including duplexes and accessible options.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

INSERT INTO
  room_categories (
    id,
    category_name,
    category_description,
    created_at,
    updated_at
  )
VALUES
  (
    10,
    'Chambre Communicante',
    'Connected rooms offering spacious accommodations for families.',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
  );

-- ROOMS
-- Chambre Deluxe (15 Rooms)
-- ROOMS
-- Chambre Deluxe (15 Rooms)
INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('101', 'Spacious rooms with modern amenities. Parisian decor with options for duplex or single-floor.', 22, 'Chambre Deluxe', 2, 2, 200.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('102', 'Elegant rooms with high ceilings and wooden flooring.', 25, 'Chambre Deluxe', 2, 2, 220.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('103', 'Deluxe rooms with private terraces and marble bathrooms.', 27, 'Chambre Deluxe', 2, 2, 250.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('104', 'Stylish duplex rooms offering panoramic city views.', 28, 'Chambre Deluxe', 2, 2, 280.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('105', 'Deluxe rooms with Eiffel Tower views and modern decor.', 30, 'Chambre Deluxe', 2, 2, 300.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('106', 'Cozy rooms with an Art Deco vibe and modern amenities.', 25, 'Chambre Deluxe', 2, 2, 210.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('107', 'Large deluxe rooms with vibrant color palettes.', 24, 'Chambre Deluxe', 2, 2, 230.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('108', 'Duplex deluxe rooms with extra seating and lighting.', 29, 'Chambre Deluxe', 2, 2, 290.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('109', 'Luxury rooms on high floors with spectacular night views.', 28, 'Chambre Deluxe', 2, 2, 280.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('110', 'Comfortable rooms with cozy decor for extended stays.', 26, 'Chambre Deluxe', 2, 2, 240.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('111', 'Spacious rooms with plush bedding and advanced lighting.', 23, 'Chambre Deluxe', 2, 2, 220.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('112', 'Rooms with minimalist styling and floor-to-ceiling windows.', 25, 'Chambre Deluxe', 2, 2, 250.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('113', 'Quiet deluxe rooms with enhanced acoustic insulation.', 27, 'Chambre Deluxe', 2, 2, 260.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('114', 'Rooms featuring modern furniture and vibrant artwork.', 24, 'Chambre Deluxe', 2, 2, 230.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('115', 'Elegant duplex rooms ideal for long stays in Paris.', 30, 'Chambre Deluxe', 2, 2, 300.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Chambre Deluxe Tour Eiffel (5 Rooms)
INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('201', 'Rooms with partial views of the Eiffel Tower. Contemporary decor.', 26, 'Chambre Deluxe Tour Eiffel', 2, 3, 350.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('202', 'Bright rooms with Eiffel Tower views and private balconies.', 27, 'Chambre Deluxe Tour Eiffel', 2, 3, 370.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('203', 'Modern rooms with floor-to-ceiling windows facing the Eiffel Tower.', 28, 'Chambre Deluxe Tour Eiffel', 2, 3, 390.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('204', 'Quiet rooms with Art Deco furniture and Eiffel Tower glimpses.', 25, 'Chambre Deluxe Tour Eiffel', 2, 3, 340.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('205', 'Romantic rooms with stunning sunset views over the Eiffel Tower.', 30, 'Chambre Deluxe Tour Eiffel', 2, 3, 400.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Junior Suite (5 Rooms)
INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('301', 'Separate living room with contemporary decor. Ideal for long stays.', 30, 'Junior Suite', 2, 4, 450.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('302', 'Suites with large seating areas and garden views.', 35, 'Junior Suite', 2, 4, 470.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('303', 'Elegant suites with luxurious bathrooms and modern amenities.', 36, 'Junior Suite', 2, 4, 500.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('304', 'Stylish duplex suites with enhanced workspace and lighting.', 32, 'Junior Suite', 2, 4, 480.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('305', 'Private suites with minimalist design and Parisian charm.', 33, 'Junior Suite', 2, 4, 490.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Suites (5 Suites)
INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('401', 'Luxurious suite with Parisian-style decor. Private terrace.', 40, 'Suite Prestige', 2, 6, 600.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('402', 'Suites with rooftop terraces and 360° views of Paris.', 45, 'Suite Terrasse Eiffel', 2, 7, 650.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('403', 'Spacious suites with fireplaces and opulent furnishings.', 50, 'Suite Marignan Eiffel', 2, 8, 700.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('404', 'Large suites with private dining areas and stunning decor.', 47, 'Suite Prestige', 2, 6, 630.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO rooms (
    room_number,
    room_description,
    room_size,
    room_type,
    room_max_persons,
    room_category_id,
    base_price,
    created_at,
    updated_at
)
VALUES
('405', 'Chic suites with grand staircases and exclusive amenities.', 48, 'Suite Marignan Eiffel', 2, 8, 720.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- ROOMS BED TYPES

INSERT INTO room_bed_types ( bed_type)
VALUES ( 'Double Bed');

INSERT INTO room_bed_types ( bed_type)
VALUES ( 'Single Bed');

INSERT INTO room_bed_types ( bed_type)
VALUES ( 'King Bed');

INSERT INTO room_bed_types ( bed_type)
VALUES ( 'Queen Bed');


-- CUSTOMERS
INSERT INTO customers (name, email, phone_number, created_at, updated_at)
VALUES ('John Doe', 'john@example.com', '555-1234', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO customers (name, email, phone_number, created_at, updated_at)
VALUES ('Jane Smith', 'jane@example.com', '555-5678', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- SEASONS
INSERT INTO seasons (name, start_date, end_date, price_multiplier, active, created_at, updated_at)
VALUES ('Summer 2026', '2026-06-01', '2026-08-31', 1.5, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO seasons (name, start_date, end_date, price_multiplier, active, created_at, updated_at)
VALUES ('Winter Sale 2026', '2026-12-01', '2027-02-28', 1.3, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- BOOKINGS
INSERT INTO bookings (room_id, customer_id, start_date, end_date, total_price, status,
                      applied_season_id, applied_multiplier, applied_season_name, created_at, updated_at)
VALUES (1, 1, '2026-06-10', '2026-06-15', 900.00, 'Booked', 1, 1.5, 'Summer 2026', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- SERVICES
INSERT INTO services ( service_type, status, cost, created_at, updated_at)
VALUES ( 'Dining', 'Pending', 50.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO services ( service_type, status, cost, created_at, updated_at)
VALUES ( 'Wifi', 'active', 0.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

