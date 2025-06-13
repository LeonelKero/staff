-- Drop table if it exists (optional - for recreation)
-- DROP TABLE IF EXISTS Employee;

-- Create Employee table
CREATE TABLE Employee (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    created_at DATETIME2 NULL,
    updated_at DATETIME2 NULL
);

-- Add indexes for better performance
CREATE INDEX IX_Employee_Email ON Employee(email);
CREATE INDEX IX_Employee_CreatedAt ON Employee(created_at);

-- Optional: Add unique constraint on email if needed
-- ALTER TABLE Employee ADD CONSTRAINT UQ_Employee_Email UNIQUE (email);

-- Optional: Add check constraint for email format
-- ALTER TABLE Employee ADD CONSTRAINT CK_Employee_Email_Format
--     CHECK (email LIKE '%_@_%._%');

-- Insert sample data (optional)
INSERT INTO Employee (name, email, created_at, updated_at) VALUES
('John Doe', 'john.doe@example.com', GETDATE(), GETDATE()),
('Jane Smith', 'jane.smith@example.com', GETDATE(), GETDATE()),
('Bob Johnson', 'bob.johnson@example.com', GETDATE(), GETDATE());

-- Verify the table structure
--SELECT
--    COLUMN_NAME,
--    DATA_TYPE,
--    IS_NULLABLE,
--    COLUMN_DEFAULT,
--    CHARACTER_MAXIMUM_LENGTH
--FROM INFORMATION_SCHEMA.COLUMNS
--WHERE TABLE_NAME = 'Employee'
--ORDER BY ORDINAL_POSITION;