import { Room } from './room.model';

export interface Category {
  id: number;
  name: string;
  description: string;
  thumbnail: string; // Thumbnail for the category
  images: string[]; // URLs for carousel images
  rooms?: Room[]; // Optional: Rooms in this category
}
