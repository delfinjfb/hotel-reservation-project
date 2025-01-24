import { Room } from './room.model';

export interface Category {
  id: number;
  categoryName: string; // Match exactly with API field names
  categoryDescription: string; // Match exactly with API field names
  basePrice?: number; // Optional if not provided by the API
  thumbnail?: string; // Optional
  images?: string[]; // Optional
  rooms?: Room[]; // Optional
}
