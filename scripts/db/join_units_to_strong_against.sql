SELECT units.id,units.unit_name,enemy_units.unit_name as strong_against
FROM units
JOIN strong_against ON units.id = strong_against.unit_id 
join units as enemy_units on enemy_units.id = strong_against.enemy_id;